import 'package:flutter/material.dart';

class LoadingWidget extends StatelessWidget {
  final bool loading;

  const LoadingWidget({
    super.key,
    required this.loading,
  });

  @override
  Widget build(BuildContext context) {
    if (!loading) {
      return const SizedBox.shrink();
    }

    return Container(
      color: Colors.white,
      child: const Center(
        child: CircularProgressIndicator(
          strokeWidth: 3,
        ),
      ),
    );
  }
}