// src/config/supabase.js
const { createClient } = require('@supabase/supabase-js');
const dotenv = require('dotenv');

// Load environment variables
dotenv.config();

const url = process.env.SUPABASE_URL?.trim();
const anon = process.env.SUPABASE_ANON_KEY?.trim();
const service = process.env.SUPABASE_SERVICE_ROLE_KEY?.trim();

if (!url) {
  console.error(' Missing SUPABASE_URL in .env');
  process.exit(1);
}

if (!service) {
  console.error(' Missing SUPABASE_SERVICE_ROLE_KEY in .env');
  process.exit(1);
}

// Admin client — full access, bypasses RLS
const supabaseAdmin = createClient(url, service, {
  auth: { autoRefreshToken: false, persistSession: false },
});

//  Auth client — safe for verifying tokens or public queries
// Fallback to service key if anon is not defined (to prevent crashes)
const supabaseAuth = createClient(url, anon || service, {
  auth: { autoRefreshToken: false, persistSession: false },
});

console.log('Supabase clients initialized:', {
  urlLoaded: !!url,
  anonLoaded: !!anon,
  serviceLoaded: !!service,
});

module.exports = { supabaseAdmin, supabaseAuth };
