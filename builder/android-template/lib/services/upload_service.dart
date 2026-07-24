import 'package:file_picker/file_picker.dart';

class UploadService {
  static Future<List<PlatformFile>> pickFiles({
    bool allowMultiple = true,
  }) async {
    final result = await FilePicker.platform.pickFiles(
      allowMultiple: allowMultiple,
      withData: true,
    );

    if (result == null) {
      return [];
    }

    return result.files;
  }

  static Future<PlatformFile?> pickFile() async {
    final files = await pickFiles(
      allowMultiple: false,
    );

    if (files.isEmpty) {
      return null;
    }

    return files.first;
  }

  static Future<List<String>> pickPaths() async {
    final files = await pickFiles();

    return files
        .where((file) => file.path != null)
        .map((file) => file.path!)
        .toList();
  }
}