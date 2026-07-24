import 'package:image_picker/image_picker.dart';

class CameraService {
  static final ImagePicker _picker = ImagePicker();

  static Future<XFile?> takePhoto() async {
    try {
      return await _picker.pickImage(
        source: ImageSource.camera,
        imageQuality: 90,
      );
    } catch (_) {
      return null;
    }
  }

  static Future<XFile?> pickFromGallery() async {
    try {
      return await _picker.pickImage(
        source: ImageSource.gallery,
        imageQuality: 90,
      );
    } catch (_) {
      return null;
    }
  }

  static Future<XFile?> recordVideo() async {
    try {
      return await _picker.pickVideo(
        source: ImageSource.camera,
      );
    } catch (_) {
      return null;
    }
  }

  static Future<List<XFile>> pickMultipleImages() async {
    try {
      return await _picker.pickMultiImage(
        imageQuality: 90,
      );
    } catch (_) {
      return [];
    }
  }
}