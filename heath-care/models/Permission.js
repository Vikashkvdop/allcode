import mongoose from "mongoose";

const PermissionSchema = new mongoose.Schema({
  role: { type: String, required: true, unique: true },
  permissions: { type: [String], default: [] }
});

export default mongoose.model("Permission", PermissionSchema);
