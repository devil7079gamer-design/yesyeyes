import 'package:flutter/material.dart';

extension StringExtensions on String {
  bool get isUrl {
    return startsWith("http://") || startsWith("https://");
  }

  bool get isEmail {
    return RegExp(
      r'^[\w\-\.]+@([\w\-]+\.)+[\w\-]{2,4}$',
    ).hasMatch(this);
  }

  bool get isPhone {
    return RegExp(r'^[0-9+\-\s()]+$').hasMatch(this);
  }
}

extension ContextExtensions on BuildContext {
  void showToast(String message) {
    ScaffoldMessenger.of(this).showSnackBar(
      SnackBar(
        content: Text(message),
        duration: const Duration(seconds: 2),
      ),
    );
  }

  double get width => MediaQuery.of(this).size.width;

  double get height => MediaQuery.of(this).size.height;

  bool get isDarkMode =>
      Theme.of(this).brightness == Brightness.dark;
}

extension WidgetExtensions on Widget {
  Widget paddingAll(double value) {
    return Padding(
      padding: EdgeInsets.all(value),
      child: this,
    );
  }

  Widget center() {
    return Center(child: this);
  }
}