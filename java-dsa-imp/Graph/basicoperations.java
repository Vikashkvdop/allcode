import java.util.*;

/**
 * A generic, adjacency-list Graph implementation with:
 * - Directed/Undirected support
 * - Weighted edges
 * - BFS / DFS (iterative & recursive)
 * - Cycle detection (directed & undirected)
 * - Dijkstra shortest path (non-negative weights)
 * - Topological sort (for DAGs)
 *
 * Compile & run:
 *   javac Main.java && java Main
 */
public class Main {
    // ---------------- Graph ----------------
    public static class Graph<T> {
        private final boolean directed;
        private final Map<T, List<Edge<T>>> adj = new HashMap<>();

        public Graph(boolean directed) {
            this.directed = directed;
        }

        private static class Edge<T> {
            final T to;
            final int weight;
            Edge(T to, int weight) { this.to = to; this.weight = weight; }
            @Override public String toString() { return "(" + to + ", w=" + weight + ")"; }
        }

        // ========== Basic operations ==========
        public void addVertex(T v) {
            adj.putIfAbsent(v, new ArrayList<>());
        }

        public void addEdge(T u, T v) {
            addEdge(u, v, 1);
        }

        public void addEdge(T u, T v, int weight) {
            addVertex(u);
            addVertex(v);
            adj.get(u).add(new Edge<>(v, weight));
            if (!directed) adj.get(v).add(new Edge<>(u, weight));
        }

        public void removeEdge(T u, T v) {
            List<Edge<T>> list = adj.get(u);
            if (list != null) list.removeIf(e -> e.to.equals(v));
            if (!directed) {
                List<Edge<T>> list2 = adj.get(v);
                if (list2 != null) list2.removeIf(e -> e.to.equals(u));
            }
        }

        public void removeVertex(T v) {
            adj.remove(v);
            for (List<Edge<T>> list : adj.values()) {
                list.removeIf(e -> e.to.equals(v));
            }
        }

        public Set<T> vertices() { return adj.keySet(); }

        public List<T> neighbors(T u) {
            List<Edge<T>> list = adj.getOrDefault(u, Collections.emptyList());
            List<T> out = new ArrayList<>(list.size());
            for (Edge<T> e : list) out.add(e.to);
            return out;
        }

        public Map<T, List<Edge<T>>> adjacency() { return adj; }

        // ========== Traversals ==========
        /** BFS: returns visit order; also fills distances if asked */
        public List<T> bfs(T start, Map<T, Integer> outDistances) {
            List<T> order = new ArrayList<>();
            if (!adj.containsKey(start)) return order;

            Queue<T> q = new ArrayDeque<>();
            Set<T> seen = new HashSet<>();
            if (outDistances != null) outDistances.clear();

            q.add(start);
            seen.add(start);
            if (outDistances != null) outDistances.put(start, 0);

            while (!q.isEmpty()) {
                T u = q.poll();
                order.add(u);
                for (Edge<T> e : adj.getOrDefault(u, Collections.emptyList())) {
                    T v = e.to;
                    if (!seen.contains(v)) {
                        seen.add(v);
                        q.add(v);
                        if (outDistances != null) outDistances.put(v, outDistances.get(u) + 1);
                    }
                }
            }
            return order;
        }

        /** DFS iterative using explicit stack */
        public List<T> dfsIterative(T start) {
            List<T> order = new ArrayList<>();
            if (!adj.containsKey(start)) return order;

            Deque<T> stack = new ArrayDeque<>();
            Set<T> seen = new HashSet<>();
            stack.push(start);

            while (!stack.isEmpty()) {
                T u = stack.pop();
                if (seen.contains(u)) continue;
                seen.add(u);
                order.add(u);
                // Push neighbors in reverse to get "natural" left-to-right feel
                List<Edge<T>> nbrs = adj.getOrDefault(u, Collections.emptyList());
                for (int i = nbrs.size() - 1; i >= 0; --i) {
                    T v = nbrs.get(i).to;
                    if (!seen.contains(v)) stack.push(v);
                }
            }
            return order;
        }

        /** DFS recursive (wrapper) */
        public List<T> dfsRecursive(T start) {
            List<T> order = new ArrayList<>();
            Set<T> seen = new HashSet<>();
            dfsRec(start, seen, order);
            return order;
        }
        private void dfsRec(T u, Set<T> seen, List<T> order) {
            if (!adj.containsKey(u) || seen.contains(u)) return;
            seen.add(u);
            order.add(u);
            for (Edge<T> e : adj.get(u)) dfsRec(e.to, seen, order);
        }

        // ========== Cycle detection ==========
        /** Undirected graph cycle detection (DFS with parent) */
        public boolean hasCycleUndirected() {
            if (directed) throw new IllegalStateException("Use hasCycleDirected() for directed graphs.");
            Set<T> seen = new HashSet<>();
            for (T start : adj.keySet()) {
                if (!seen.contains(start) && dfsCycleUndirected(start, null, seen)) return true;
            }
            return false;
        }
        private boolean dfsCycleUndirected(T u, T parent, Set<T> seen) {
            seen.add(u);
            for (Edge<T> e : adj.getOrDefault(u, Collections.emptyList())) {
                T v = e.to;
                if (!seen.contains(v)) {
                    if (dfsCycleUndirected(v, u, seen)) return true;
                } else if (!v.equals(parent)) {
                    return true; // found a back-edge
                }
            }
            return false;
        }

        /** Directed graph cycle detection using colors: 0=unseen,1=visiting,2=done */
        public boolean hasCycleDirected() {
            if (!directed) throw new IllegalStateException("Use hasCycleUndirected() for undirected graphs.");
            Map<T, Integer> color = new HashMap<>();
            for (T v : adj.keySet()) color.put(v, 0);
            for (T v : adj.keySet()) {
                if (color.get(v) == 0 && dfsCycleDirected(v, color)) return true;
            }
            return false;
        }
        private boolean dfsCycleDirected(T u, Map<T, Integer> color) {
            color.put(u, 1);
            for (Edge<T> e : adj.getOrDefault(u, Collections.emptyList())) {
                T v = e.to;
                int c = color.getOrDefault(v, 0);
                if (c == 1) return true; // back-edge -> cycle
                if (c == 0 && dfsCycleDirected(v, color)) return true;
            }
            color.put(u, 2);
            return false;
        }

        // ========== Dijkstra (non-negative weights) ==========
        public Map<T, Integer> dijkstra(T source, Map<T, T> outParent) {
            if (outParent != null) outParent.clear();
            Map<T, Integer> dist = new HashMap<>();
            for (T v : adj.keySet()) dist.put(v, Integer.MAX_VALUE);
            if (!adj.containsKey(source)) return dist;

            PriorityQueue<Node<T>> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
            dist.put(source, 0);
            pq.add(new Node<>(source, 0));

            while (!pq.isEmpty()) {
                Node<T> cur = pq.poll();
                if (cur.dist != dist.get(cur.v)) continue; // stale
                for (Edge<T> e : adj.getOrDefault(cur.v, Collections.emptyList())) {
                    if (e.weight < 0) throw new IllegalArgumentException("Dijkstra requires non-negative weights.");
                    int nd = cur.dist + e.weight;
                    if (nd < dist.getOrDefault(e.to, Integer.MAX_VALUE)) {
                        dist.put(e.to, nd);
                        if (outParent != null) outParent.put(e.to, cur.v);
                        pq.add(new Node<>(e.to, nd));
                    }
                }
            }
            return dist;
        }

        /** Reconstruct path using a parent map filled by Dijkstra/BFS. */
        public List<T> reconstructPath(T src, T dest, Map<T, T> parent) {
            List<T> path = new ArrayList<>();
            if (src.equals(dest)) { path.add(src); return path; }
            if (parent == null || !parent.containsKey(dest)) return path; // empty if unreachable
            for (T at = dest; at != null; at = parent.get(at)) {
                path.add(at);
                if (at.equals(src)) break;
            }
            Collections.reverse(path);
            if (path.isEmpty() || !path.get(0).equals(src)) return Collections.emptyList();
            return path;
        }

        // ========== Topological Sort (Kahn) ==========
        public List<T> topoSort() {
            if (!directed) throw new IllegalStateException("Topological sort is for directed graphs.");
            Map<T, Integer> indeg = new HashMap<>();
            for (T v : adj.keySet()) indeg.put(v, 0);
            for (T u : adj.keySet()) {
                for (Edge<T> e : adj.get(u)) {
                    indeg.put(e.to, indeg.getOrDefault(e.to, 0) + 1);
                }
            }
            Queue<T> q = new ArrayDeque<>();
            for (Map.Entry<T, Integer> en : indeg.entrySet()) if (en.getValue() == 0) q.add(en.getKey());

            List<T> order = new ArrayList<>();
            while (!q.isEmpty()) {
                T u = q.poll();
                order.add(u);
                for (Edge<T> e : adj.getOrDefault(u, Collections.emptyList())) {
                    int d = indeg.get(e.to) - 1;
                    indeg.put(e.to, d);
                    if (d == 0) q.add(e.to);
                }
            }
            // If not all vertices are in order, there was a cycle
            if (order.size() != adj.size())
                throw new IllegalStateException("Graph has a cycle; topological sort not possible.");
            return order;
        }

        private static class Node<T> {
            final T v; final int dist;
            Node(T v, int dist) { this.v = v; this.dist = dist; }
        }

        @Override public String toString() {
            StringBuilder sb = new StringBuilder(directed ? "Directed" : "Undirected").append(" graph:\n");
            for (T u : adj.keySet()) {
                sb.append("  ").append(u).append(" -> ").append(adj.get(u)).append("\n");
            }
            return sb.toString();
        }
    }

    // ---------------- Demo / Examples ----------------
    public static void main(String[] args) {
        // 1) Undirected, unweighted example
        Graph<Integer> g = new Graph<>(false);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);

        System.out.println("UNDIRECTED GRAPH");
        System.out.println(g);

        Map<Integer, Integer> bfsDist = new HashMap<>();
        System.out.println("BFS from 1 (order): " + g.bfs(1, bfsDist));
        System.out.println("BFS distances from 1: " + bfsDist);
        System.out.println("DFS (iterative) from 1: " + g.dfsIterative(1));
        System.out.println("DFS (recursive) from 1: " + g.dfsRecursive(1));
        System.out.println("Has cycle (undirected)? " + g.hasCycleUndirected());
        System.out.println();

        // 2) Directed, weighted example + Dijkstra + Topo Sort
        Graph<String> dg = new Graph<>(true);
        dg.addEdge("A", "B", 2);
        dg.addEdge("A", "C", 5);
        dg.addEdge("B", "D", 4);
        dg.addEdge("C", "D", 1);
        dg.addEdge("D", "E", 3);

        System.out.println("DIRECTED WEIGHTED GRAPH");
        System.out.println(dg);

        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> dist = dg.dijkstra("A", parent);
        System.out.println("Dijkstra distances from A: " + dist);
        System.out.println("Shortest path A -> E: " + dg.reconstructPath("A", "E", parent));

        // Topo sort works only for DAGs. Our example is a DAG:
        try {
            System.out.println("Topological order: " + dg.topoSort());
        } catch (IllegalStateException cycle) {
            System.out.println("Topological sort failed: " + cycle.getMessage());
        }

        // 3) Directed cycle detection example
        Graph<Integer> cyc = new Graph<>(true);
        cyc.addEdge(1, 2);
        cyc.addEdge(2, 3);
        cyc.addEdge(3, 1); // cycle
        System.out.println("\nDirected cycle present? " + cyc.hasCycleDirected());
    }
}
