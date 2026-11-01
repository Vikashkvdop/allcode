const { supabase, supabaseAuth } = require("../config/supabase");


/**
 * POST /auth/signin
 * Body: { email, password }
 * Returns: { user, access_token, refresh_token, token_type, expires_in }
 */
async function signIn(req, res) {
  try {
    const { email, password } = req.body || {};
    if (!email || !password) {
      return res.status(400).json({ error: 'email and password are required' });
    }

    const { data, error } = await supabaseAuth.auth.signInWithPassword({ email, password });
    if (error) {
      return res.status(401).json({ error: error.message });
    }

    const { user, session } = data || {};
    return res.json({
      user,
      access_token: session?.access_token,
      refresh_token: session?.refresh_token,
      token_type: 'bearer',
      expires_in: session?.expires_in
    });
  } catch (e) {
    console.error('signIn error:', e);
    return res.status(500).json({ error: 'internal server error' });
  }
}

/**
 * POST /auth/signout
 * Expects Authorization: Bearer <access_token>
 * Invalidates the current session on Supabase.
 */
async function signOut(req, res) {
  try {
    // If you pass the user’s access token, Supabase will revoke that session.
    // We already extracted the token in the auth middleware for protected routes,
    // but signout can work without prior auth middleware — we’ll parse header here.
    const auth = req.headers.authorization || '';
    const token = auth.startsWith('Bearer ') ? auth.slice(7) : null;

    if (!token) {
      return res.status(400).json({ error: 'missing bearer token' });
    }

    // Supabase logout for the current token:
    const { error } = await supabase.auth.signOut({ scope: 'local' });
    if (error) return res.status(400).json({ error: error.message });

    return res.json({ message: 'signed out' });
  } catch (e) {
    console.error('signOut error:', e);
    return res.status(500).json({ error: 'internal server error' });
  }
}

module.exports = { signIn, signOut };
