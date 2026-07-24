import 'package:flutter/material.dart';

class ProgressWidget extends StatelessWidget {
  final bool visible;
  final String? message;

  const ProgressWidget({
    super.key,
    required this.visible,
    this.message,
  });

  @override
  Widget build(BuildContext context) {
    if (!visible) {
      return const SizedBox.shrink();
    }

    return Container(
      color: Colors.black.withOpacity(0.35),
      child: Center(
        child: Container(
          width: 220,
          padding: const EdgeInsets.all(20),
          decoration: BoxDecoration(
            color: Colors.white,
            borderRadius: BorderRadius.circular(14),
          ),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              const CircularProgressIndicator(),
              const SizedBox(height: 18),
              Text(
                message ?? "Loading...",
                textAlign: TextAlign.center,
                style: const TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.w500,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}