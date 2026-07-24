import 'package:file_picker/file_picker.dart';

class FilePickerService {
  static Future<List<String>> pickFiles() async {
    final result = await FilePicker.platform.pickFiles(
      allowMultiple: true,
      withData: false,
    );

    if (result == null) {
      return [];
    }

    return result.files
        .where((e) => e.path != null)
        .map((e) => e.path!)
        .toList();
  }

  static Future<String?> pickSingleFile() async {
    final result = await FilePicker.platform.pickFiles(
      allowMultiple: false,
      withData: false,
    );

    if (result == null) {
      return null;
    }

    return result.files.single.path;
  }
}