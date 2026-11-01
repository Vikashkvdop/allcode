const { supabase, supabaseAuth } = require('../config/supabase');

async function requireAuth(req, res, next) {
  const auth = req.headers.authorization || '';
  const token = auth.startsWith('Bearer ') ? auth.slice(7) : null;
  if (!token) return res.status(401).json({ error: 'missing bearer token' });

  const { data, error } = await supabaseAuth.auth.getUser(token);
  if (error || !data?.user) return res.status(401).json({ error: 'invalid or expired token' });

  req.user = data.user;
  next();
}

module.exports = { requireAuth };
