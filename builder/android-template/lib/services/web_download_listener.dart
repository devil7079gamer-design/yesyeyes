import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

class WebDownloadListener {
  static Future<void> download(
    BuildContext context,
    String url,
  ) async {
    try {
      final uri = Uri.parse(url);

      final success = await launchUrl(
        uri,
        mode: LaunchMode.externalApplication,
      );

      if (!success) {
        throw Exception("Unable to open download");
      }
    } catch (e) {
      if (!context.mounted) return;

      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          content: Text(
            "Download Failed\n$e",
          ),
        ),
      );
    }
  }

  static bool isDownloadable(String url) {
    final lower = url.toLowerCase();

    return lower.endsWith(".apk") ||
        lower.endsWith(".zip") ||
        lower.endsWith(".rar") ||
        lower.endsWith(".7z") ||
        lower.endsWith(".pdf") ||
        lower.endsWith(".doc") ||
        lower.endsWith(".docx") ||
        lower.endsWith(".xls") ||
        lower.endsWith(".xlsx") ||
        lower.endsWith(".ppt") ||
        lower.endsWith(".pptx") ||
        lower.endsWith(".mp3") ||
        lower.endsWith(".mp4") ||
        lower.endsWith(".png") ||
        lower.endsWith(".jpg") ||
        lower.endsWith(".jpeg");
  }
}