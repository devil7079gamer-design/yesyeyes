import 'dart:io';

import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

class DownloadService {
  static Future<void> downloadFile(
    BuildContext context,
    String url,
  ) async {
    try {
      final uri = Uri.parse(url);

      if (!await launchUrl(
        uri,
        mode: LaunchMode.externalApplication,
      )) {
        throw Exception("Cannot open download link");
      }
    } catch (e) {
      if (context.mounted) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(
            content: Text("Download failed\n$e"),
          ),
        );
      }
    }
  }

  static Future<void> openFile(String path) async {
    final file = File(path);

    if (!await file.exists()) return;

    await launchUrl(
      Uri.file(file.path),
      mode: LaunchMode.externalApplication,
    );
  }

  static Future<void> openUrl(String url) async {
    final uri = Uri.parse(url);

    await launchUrl(
      uri,
      mode: LaunchMode.externalApplication,
    );
  }
}