const jwt = require('jsonwebtoken');

exports.generateToken = (user) => {
  return jwt.sign(
    { sub: user._id, roles: user.roles },
    process.env.JWT_SECRET,
    { expiresIn: "1h" }
  );
};
