import 'package:flutter/material.dart';

class SplashLogo extends StatelessWidget {
  final String? asset;
  final double size;

  const SplashLogo({
    super.key,
    this.asset,
    this.size = 120,
  });

  @override
  Widget build(BuildContext context) {
    if (asset != null && asset!.isNotEmpty) {
      return Image.asset(
        asset!,
        width: size,
        height: size,
        fit: BoxFit.contain,
        errorBuilder: (_, __, ___) {
          return Icon(
            Icons.language,
            size: size,
            color: Colors.blue,
          );
        },
      );
    }

    return Icon(
      Icons.language,
      size: size,
      color: Colors.blue,
    );
  }
}