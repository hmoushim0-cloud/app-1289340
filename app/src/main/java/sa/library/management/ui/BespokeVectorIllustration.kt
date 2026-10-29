package sa.library.management.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun BespokeVectorIllustration(
    archetype: String,
    screenIdx: Int,
    modifier: Modifier = Modifier.fillMaxWidth().height(160.dp),
    primaryColor: Color = MaterialTheme.colorScheme.primary,
    secondaryColor: Color = MaterialTheme.colorScheme.secondary
) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val cx = w / 2f
        val cy = h / 2f

        // Draw >= 8 distinct bespoke vector paths with Path() and Canvas
        when (screenIdx) {
            1 -> {
                // Vector Path 1: Primary Horizon Curve
                val p1 = Path().apply {
                    moveTo(cx - 140f, cy + 20f)
                    cubicTo(cx - 70f, cy - 60f, cx + 70f, cy + 80f, cx + 140f, cy)
                }
                drawPath(p1, color = primaryColor, style = Stroke(width = 6f, cap = StrokeCap.Round))

                // Vector Path 2: Secondary Contour Arc
                val p2 = Path().apply {
                    moveTo(cx - 120f, cy + 40f)
                    cubicTo(cx - 50f, cy + 90f, cx + 50f, cy - 30f, cx + 120f, cy + 30f)
                }
                drawPath(p2, color = secondaryColor, style = Stroke(width = 4f, cap = StrokeCap.Round))

                // Vector Path 3: Geometric Outer Shield
                val p3 = Path().apply {
                    addOval(Rect(cx - 80f, cy - 60f, cx + 80f, cy + 60f))
                }
                drawPath(p3, color = primaryColor.copy(alpha = 0.15f), style = Fill)

                // Vector Path 4: Target Reticle Ring
                val p4 = Path().apply {
                    addOval(Rect(cx - 45f, cy - 45f, cx + 45f, cy + 45f))
                }
                drawPath(p4, color = secondaryColor, style = Stroke(width = 3f))

                // Vector Path 5: North Alignment Ray
                val p5 = Path().apply {
                    moveTo(cx, cy - 75f)
                    lineTo(cx, cy - 45f)
                }
                drawPath(p5, color = secondaryColor, style = Stroke(width = 4f))

                // Vector Path 6: South Alignment Ray
                val p6 = Path().apply {
                    moveTo(cx, cy + 45f)
                    lineTo(cx, cy + 75f)
                }
                drawPath(p6, color = secondaryColor, style = Stroke(width = 4f))

                // Vector Path 7: East-West Grid Rays
                val p7 = Path().apply {
                    moveTo(cx - 75f, cy)
                    lineTo(cx - 45f, cy)
                    moveTo(cx + 45f, cy)
                    lineTo(cx + 75f, cy)
                }
                drawPath(p7, color = secondaryColor, style = Stroke(width = 4f))

                // Vector Path 8: Core Diamond Pin
                val p8 = Path().apply {
                    moveTo(cx, cy - 14f)
                    lineTo(cx + 14f, cy)
                    lineTo(cx, cy + 14f)
                    lineTo(cx - 14f, cy)
                    close()
                }
                drawPath(p8, color = Color.White, style = Fill)
            }
            2 -> {
                // Vector Path 1: Sine Route Curve
                val p1 = Path().apply {
                    moveTo(cx - 150f, cy)
                    cubicTo(cx - 80f, cy - 70f, cx - 20f, cy + 70f, cx + 50f, cy - 40f)
                    cubicTo(cx + 90f, cy - 80f, cx + 130f, cy - 20f, cx + 150f, cy - 10f)
                }
                drawPath(p1, color = primaryColor, style = Stroke(width = 6f, cap = StrokeCap.Round))

                // Vector Path 2: Waypoint Step Indicator
                val p2 = Path().apply {
                    addOval(Rect(cx - 155f, cy - 8f, cx - 139f, cy + 8f))
                }
                drawPath(p2, color = primaryColor, style = Fill)

                // Vector Path 3: Midway Waypoint
                val p3 = Path().apply {
                    addOval(Rect(cx - 5f, cy - 8f, cx + 11f, cy + 8f))
                }
                drawPath(p3, color = secondaryColor, style = Fill)

                // Vector Path 4: Target Destination Pin
                val p4 = Path().apply {
                    addOval(Rect(cx + 138f, cy - 18f, cx + 162f, cy + 6f))
                }
                drawPath(p4, color = Color(0xFF10B981), style = Fill)

                // Vector Path 5: Top Diagnostic Metric Ray
                val p5 = Path().apply {
                    moveTo(cx - 100f, cy - 50f)
                    lineTo(cx + 100f, cy - 50f)
                }
                drawPath(p5, color = primaryColor.copy(alpha = 0.3f), style = Stroke(width = 2f))

                // Vector Path 6: Bottom Diagnostic Metric Ray
                val p6 = Path().apply {
                    moveTo(cx - 120f, cy + 50f)
                    lineTo(cx + 120f, cy + 50f)
                }
                drawPath(p6, color = secondaryColor.copy(alpha = 0.3f), style = Stroke(width = 2f))

                // Vector Path 7: Metric Tick Marks
                val p7 = Path().apply {
                    moveTo(cx - 60f, cy + 45f); lineTo(cx - 60f, cy + 55f)
                    moveTo(cx, cy + 45f); lineTo(cx, cy + 55f)
                    moveTo(cx + 60f, cy + 45f); lineTo(cx + 60f, cy + 55f)
                }
                drawPath(p7, color = secondaryColor, style = Stroke(width = 3f))

                // Vector Path 8: Success Checkmark Path
                val p8 = Path().apply {
                    moveTo(cx + 144f, cy - 6f)
                    lineTo(cx + 149f, cy - 1f)
                    lineTo(cx + 157f, cy - 11f)
                }
                drawPath(p8, color = Color.White, style = Stroke(width = 3f, cap = StrokeCap.Round))
            }
            else -> {
                // Vector Path 1: Background Radial Gauge Arc
                val p1 = Path().apply {
                    arcTo(Rect(cx - 80f, cy - 60f, cx + 80f, cy + 60f), 150f, 240f, false)
                }
                drawPath(p1, color = Color(0xFF334155), style = Stroke(width = 10f, cap = StrokeCap.Round))

                // Vector Path 2: Active Gauge Fill Arc
                val p2 = Path().apply {
                    arcTo(Rect(cx - 80f, cy - 60f, cx + 80f, cy + 60f), 150f, 170f, false)
                }
                drawPath(p2, color = primaryColor, style = Stroke(width = 10f, cap = StrokeCap.Round))

                // Vector Path 3: Peak Indicator Arc
                val p3 = Path().apply {
                    arcTo(Rect(cx - 80f, cy - 60f, cx + 80f, cy + 60f), 320f, 50f, false)
                }
                drawPath(p3, color = secondaryColor, style = Stroke(width = 10f, cap = StrokeCap.Round))

                // Vector Path 4: Central Gauge Hub
                val p4 = Path().apply {
                    addOval(Rect(cx - 16f, cy - 16f, cx + 16f, cy + 16f))
                }
                drawPath(p4, color = secondaryColor, style = Fill)

                // Vector Path 5: Needle Pointer
                val p5 = Path().apply {
                    moveTo(cx, cy)
                    lineTo(cx + 45f, cy - 35f)
                }
                drawPath(p5, color = Color.White, style = Stroke(width = 5f, cap = StrokeCap.Round))

                // Vector Path 6: Base Calibrator Ray 1
                val p6 = Path().apply {
                    moveTo(cx - 90f, cy + 30f)
                    lineTo(cx - 75f, cy + 20f)
                }
                drawPath(p6, color = Color.Gray, style = Stroke(width = 3f))

                // Vector Path 7: Base Calibrator Ray 2
                val p7 = Path().apply {
                    moveTo(cx + 90f, cy + 30f)
                    lineTo(cx + 75f, cy + 20f)
                }
                drawPath(p7, color = Color.Gray, style = Stroke(width = 3f))

                // Vector Path 8: Cryptographic Seal Badge
                val p8 = Path().apply {
                    moveTo(cx - 20f, cy + 45f)
                    lineTo(cx + 20f, cy + 45f)
                    lineTo(cx, cy + 65f)
                    close()
                }
                drawPath(p8, color = primaryColor.copy(alpha = 0.8f), style = Fill)
            }
        }
    }
}
