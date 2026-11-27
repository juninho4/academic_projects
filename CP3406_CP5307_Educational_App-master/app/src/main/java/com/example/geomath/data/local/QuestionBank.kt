package com.example.geomath.data.local

import com.example.geomath.domain.model.Question

object QuestionBank {

    val questions = listOf(

        // =========================================================
        // ANGLES
        // =========================================================

        Question(
            id = 1,
            topic = "Angles",
            difficulty = "Easy",
            questionText = "Two angles are complementary. One angle is 35°. What is the other angle?",
            options = listOf("45°", "55°", "65°", "75°"),
            correctAnswer = "55°",
            explanation = "Complementary angles add up to 90°. Therefore, 90° - 35° = 55°."
        ),

        Question(
            id = 2,
            topic = "Angles",
            difficulty = "Easy",
            questionText = "Two angles are supplementary. One angle is 120°. What is the other angle?",
            options = listOf("40°", "50°", "60°", "70°"),
            correctAnswer = "60°",
            explanation = "Supplementary angles add up to 180°. Therefore, 180° - 120° = 60°."
        ),

        Question(
            id = 3,
            topic = "Angles",
            difficulty = "Medium",
            questionText = "Two angles on a straight line are 3x° and 60°. What is x?",
            options = listOf("20", "30", "40", "60"),
            correctAnswer = "40",
            explanation = "Angles on a straight line add to 180°. 3x + 60 = 180, so 3x = 120 and x = 40."
        ),

        Question(
            id = 4,
            topic = "Angles",
            difficulty = "Medium",
            questionText = "Two vertically opposite angles are formed. One angle is 72°. What is the opposite angle?",
            options = listOf("36°", "72°", "108°", "144°"),
            correctAnswer = "72°",
            explanation = "Vertically opposite angles are equal, so the opposite angle is 72°."
        ),

        Question(
            id = 5,
            topic = "Angles",
            difficulty = "Hard",
            questionText = "Two angles on a straight line are (2x + 10)° and (3x - 20)°. What is x?",
            options = listOf("32", "38", "42", "48"),
            correctAnswer = "38",
            explanation = "Angles on a straight line add to 180°. Therefore, (2x + 10) + (3x - 20) = 180. This gives 5x - 10 = 180, so x = 38."
        ),

        Question(
            id = 6,
            topic = "Angles",
            difficulty = "Hard",
            questionText = "Three angles around a point are 85°, 120°, and x°. What is x?",
            options = listOf("145°", "155°", "165°", "175°"),
            correctAnswer = "155°",
            explanation = "Angles around a point add to 360°. Therefore, x = 360 - 85 - 120 = 155°."
        ),

        // =========================================================
        // TRIANGLES
        // =========================================================

        Question(
            id = 7,
            topic = "Triangles",
            difficulty = "Easy",
            questionText = "A triangle has angles of 50° and 60°. What is the third angle?",
            options = listOf("60°", "70°", "80°", "90°"),
            correctAnswer = "70°",
            explanation = "The angles inside a triangle add up to 180°. 180° - 50° - 60° = 70°."
        ),

        Question(
            id = 8,
            topic = "Triangles",
            difficulty = "Easy",
            questionText = "What type of triangle has three equal sides?",
            options = listOf(
                "Scalene",
                "Isosceles",
                "Equilateral",
                "Right-angled"
            ),
            correctAnswer = "Equilateral",
            explanation = "An equilateral triangle has three equal sides and three equal angles."
        ),

        Question(
            id = 9,
            topic = "Triangles",
            difficulty = "Medium",
            questionText = "A right-angled triangle has one angle of 35°. What is the other non-right angle?",
            options = listOf("45°", "55°", "65°", "75°"),
            correctAnswer = "55°",
            explanation = "The two non-right angles in a right-angled triangle add to 90°. Therefore, 90° - 35° = 55°."
        ),

        Question(
            id = 10,
            topic = "Triangles",
            difficulty = "Medium",
            questionText = "An isosceles triangle has two equal angles of 50°. What is the third angle?",
            options = listOf("60°", "70°", "80°", "90°"),
            correctAnswer = "80°",
            explanation = "The angles of a triangle add to 180°. Therefore, 180° - 50° - 50° = 80°."
        ),

        Question(
            id = 11,
            topic = "Triangles",
            difficulty = "Hard",
            questionText = "The angles of a triangle are x°, 2x°, and 3x°. What is x?",
            options = listOf("20", "30", "40", "60"),
            correctAnswer = "30",
            explanation = "The angles of a triangle add to 180°. Therefore, x + 2x + 3x = 180, so 6x = 180 and x = 30."
        ),

        Question(
            id = 12,
            topic = "Triangles",
            difficulty = "Hard",
            questionText = "A triangle has angles of (x + 20)°, (2x + 10)°, and 60°. What is x?",
            options = listOf("20", "25", "30", "35"),
            correctAnswer = "30",
            explanation = "The angles add to 180°. Therefore, (x + 20) + (2x + 10) + 60 = 180. This gives 3x + 90 = 180, so x = 30."
        ),

        // =========================================================
        // QUADRILATERALS
        // =========================================================

        Question(
            id = 13,
            topic = "Quadrilaterals",
            difficulty = "Easy",
            questionText = "What is the sum of the interior angles of a quadrilateral?",
            options = listOf("180°", "270°", "360°", "540°"),
            correctAnswer = "360°",
            explanation = "The interior angles of every quadrilateral add up to 360°."
        ),

        Question(
            id = 14,
            topic = "Quadrilaterals",
            difficulty = "Easy",
            questionText = "How many equal sides does a square have?",
            options = listOf("1", "2", "3", "4"),
            correctAnswer = "4",
            explanation = "A square has four equal sides and four right angles."
        ),

        Question(
            id = 15,
            topic = "Quadrilaterals",
            difficulty = "Medium",
            questionText = "A rectangle has a length of 12 cm and width of 5 cm. What is its perimeter?",
            options = listOf("17 cm", "24 cm", "34 cm", "60 cm"),
            correctAnswer = "34 cm",
            explanation = "Perimeter = 2 × (length + width) = 2 × (12 + 5) = 34 cm."
        ),

        Question(
            id = 16,
            topic = "Quadrilaterals",
            difficulty = "Medium",
            questionText = "A parallelogram has a base of 10 cm and a perpendicular height of 6 cm. What is its area?",
            options = listOf("16 cm²", "30 cm²", "60 cm²", "120 cm²"),
            correctAnswer = "60 cm²",
            explanation = "Area of a parallelogram = base × perpendicular height = 10 × 6 = 60 cm²."
        ),

        Question(
            id = 17,
            topic = "Quadrilaterals",
            difficulty = "Hard",
            questionText = "A rectangle has a perimeter of 50 cm and a length of 15 cm. What is its width?",
            options = listOf("8 cm", "10 cm", "12 cm", "15 cm"),
            correctAnswer = "10 cm",
            explanation = "Perimeter = 2(length + width). Therefore, 50 = 2(15 + width). So 25 = 15 + width, giving a width of 10 cm."
        ),

        Question(
            id = 18,
            topic = "Quadrilaterals",
            difficulty = "Hard",
            questionText = "A square has an area of 144 cm². What is its perimeter?",
            options = listOf("24 cm", "36 cm", "48 cm", "72 cm"),
            correctAnswer = "48 cm",
            explanation = "The side length is √144 = 12 cm. Therefore, the perimeter is 4 × 12 = 48 cm."
        ),

        // =========================================================
        // AREA & PERIMETER
        // =========================================================

        Question(
            id = 19,
            topic = "Area & Perimeter",
            difficulty = "Easy",
            questionText = "What is the area of a rectangle with length 10 cm and width 5 cm?",
            options = listOf("15 cm²", "30 cm²", "50 cm²", "100 cm²"),
            correctAnswer = "50 cm²",
            explanation = "Area = length × width = 10 × 5 = 50 cm²."
        ),

        Question(
            id = 20,
            topic = "Area & Perimeter",
            difficulty = "Easy",
            questionText = "A square has a side length of 6 cm. What is its perimeter?",
            options = listOf("12 cm", "18 cm", "24 cm", "36 cm"),
            correctAnswer = "24 cm",
            explanation = "Perimeter of a square = 4 × side = 4 × 6 = 24 cm."
        ),

        Question(
            id = 21,
            topic = "Area & Perimeter",
            difficulty = "Medium",
            questionText = "A square has a side length of 8 cm. What is its area?",
            options = listOf("16 cm²", "32 cm²", "64 cm²", "128 cm²"),
            correctAnswer = "64 cm²",
            explanation = "Area of a square = side × side = 8 × 8 = 64 cm²."
        ),

        Question(
            id = 22,
            topic = "Area & Perimeter",
            difficulty = "Medium",
            questionText = "A triangle has a base of 12 cm and a perpendicular height of 5 cm. What is its area?",
            options = listOf("17 cm²", "30 cm²", "60 cm²", "120 cm²"),
            correctAnswer = "30 cm²",
            explanation = "Area of a triangle = ½ × base × height = ½ × 12 × 5 = 30 cm²."
        ),

        Question(
            id = 23,
            topic = "Area & Perimeter",
            difficulty = "Hard",
            questionText = "A rectangle has an area of 72 cm² and a width of 8 cm. What is its length?",
            options = listOf("7 cm", "8 cm", "9 cm", "10 cm"),
            correctAnswer = "9 cm",
            explanation = "Area = length × width. Therefore, length = 72 ÷ 8 = 9 cm."
        ),

        Question(
            id = 24,
            topic = "Area & Perimeter",
            difficulty = "Hard",
            questionText = "A rectangle has an area of 96 cm² and a length of 12 cm. What is its perimeter?",
            options = listOf("32 cm", "40 cm", "48 cm", "56 cm"),
            correctAnswer = "40 cm",
            explanation = "Width = 96 ÷ 12 = 8 cm. Perimeter = 2(12 + 8) = 40 cm."
        ),

        // =========================================================
        // CIRCLES
        // =========================================================

        Question(
            id = 25,
            topic = "Circles",
            difficulty = "Easy",
            questionText = "What is the diameter of a circle with a radius of 7 cm?",
            options = listOf("3.5 cm", "7 cm", "14 cm", "21 cm"),
            correctAnswer = "14 cm",
            explanation = "Diameter = 2 × radius. Therefore, 2 × 7 = 14 cm."
        ),

        Question(
            id = 26,
            topic = "Circles",
            difficulty = "Easy",
            questionText = "What is the radius of a circle with a diameter of 20 cm?",
            options = listOf("5 cm", "10 cm", "15 cm", "40 cm"),
            correctAnswer = "10 cm",
            explanation = "The radius is half the diameter. Therefore, 20 ÷ 2 = 10 cm."
        ),

        Question(
            id = 27,
            topic = "Circles",
            difficulty = "Medium",
            questionText = "Using π = 22/7, what is the circumference of a circle with radius 7 cm?",
            options = listOf("22 cm", "44 cm", "77 cm", "154 cm"),
            correctAnswer = "44 cm",
            explanation = "Circumference = 2πr = 2 × 22/7 × 7 = 44 cm."
        ),

        Question(
            id = 28,
            topic = "Circles",
            difficulty = "Medium",
            questionText = "Using π = 22/7, what is the circumference of a circle with diameter 14 cm?",
            options = listOf("22 cm", "44 cm", "88 cm", "154 cm"),
            correctAnswer = "44 cm",
            explanation = "Circumference = πd = 22/7 × 14 = 44 cm."
        ),

        Question(
            id = 29,
            topic = "Circles",
            difficulty = "Hard",
            questionText = "Using π = 22/7, what is the area of a circle with radius 7 cm?",
            options = listOf("44 cm²", "77 cm²", "154 cm²", "308 cm²"),
            correctAnswer = "154 cm²",
            explanation = "Area = πr² = 22/7 × 7 × 7 = 154 cm²."
        ),

        Question(
            id = 30,
            topic = "Circles",
            difficulty = "Hard",
            questionText = "Using π = 22/7, a circle has an area of 616 cm². What is its radius?",
            options = listOf("7 cm", "14 cm", "21 cm", "28 cm"),
            correctAnswer = "14 cm",
            explanation = "Area = πr². Therefore, 616 = 22/7 × r². This gives r² = 196, so r = 14 cm."
        ),

        // =========================================================
        // VOLUME
        // =========================================================

        Question(
            id = 31,
            topic = "Volume",
            difficulty = "Easy",
            questionText = "What is the volume of a cube with side length 3 cm?",
            options = listOf("9 cm³", "18 cm³", "27 cm³", "36 cm³"),
            correctAnswer = "27 cm³",
            explanation = "Volume of a cube = side³ = 3 × 3 × 3 = 27 cm³."
        ),

        Question(
            id = 32,
            topic = "Volume",
            difficulty = "Easy",
            questionText = "What is the volume of a cuboid with length 5 cm, width 4 cm, and height 2 cm?",
            options = listOf("20 cm³", "30 cm³", "40 cm³", "50 cm³"),
            correctAnswer = "40 cm³",
            explanation = "Volume = length × width × height = 5 × 4 × 2 = 40 cm³."
        ),

        Question(
            id = 33,
            topic = "Volume",
            difficulty = "Medium",
            questionText = "A cuboid has dimensions 8 cm × 5 cm × 3 cm. What is its volume?",
            options = listOf("40 cm³", "80 cm³", "120 cm³", "160 cm³"),
            correctAnswer = "120 cm³",
            explanation = "Volume = length × width × height = 8 × 5 × 3 = 120 cm³."
        ),

        Question(
            id = 34,
            topic = "Volume",
            difficulty = "Medium",
            questionText = "A cube has a volume of 64 cm³. What is the length of each side?",
            options = listOf("2 cm", "4 cm", "6 cm", "8 cm"),
            correctAnswer = "4 cm",
            explanation = "The cube root of 64 is 4 because 4 × 4 × 4 = 64."
        ),

        Question(
            id = 35,
            topic = "Volume",
            difficulty = "Hard",
            questionText = "A cuboid has a volume of 180 cm³, a length of 9 cm, and a width of 5 cm. What is its height?",
            options = listOf("2 cm", "4 cm", "6 cm", "8 cm"),
            correctAnswer = "4 cm",
            explanation = "Volume = length × width × height. Therefore, 180 = 9 × 5 × height. So height = 180 ÷ 45 = 4 cm."
        ),

        Question(
            id = 36,
            topic = "Volume",
            difficulty = "Hard",
            questionText = "A cube has a total volume of 216 cm³. What is its surface area?",
            options = listOf("36 cm²", "72 cm²", "216 cm²", "324 cm²"),
            correctAnswer = "216 cm²",
            explanation = "The side length is 6 cm because 6³ = 216. Surface area = 6 × 6² = 216 cm²."
        )
    )
}