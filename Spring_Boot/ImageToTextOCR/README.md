====================================
           ImageToTextOCR
====================================

Description:
-------------
ImageToTextOCR is a Spring Boot application that uses Tesseract OCR to extract text from images. 
It provides an intuitive web interface with drag-and-drop functionality and a REST API for automated image-to-text conversion.

Features:
-------------
- Drag & drop interface for easy image upload
- Real-time image preview before processing
- Properly formatted text output with preserved spacing
- Copy-to-clipboard functionality for extracted text
- Support for multiple image formats (JPG, PNG, etc.)
- REST API for programmatic access
- Clean, modern UI with responsive design
- Precise text extraction with proper line breaks and indentation

Technologies Used:
-------------------
- Spring Boot
- Tesseract OCR
- Maven
- Thymeleaf
- Modern JavaScript (ES6+)
- Font Awesome icons
- Responsive CSS

Prerequisites:
--------------
- Java 11 or later (JDK)
- Maven
- Tesseract OCR installed on your system

Installation:
-------------
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/ImageToTextOCR.git
   cd ImageToTextOCR
   ```

2. Install dependencies using Maven:
   ```bash
   mvn clean install
   ```

3. Configure Tesseract:
   - Install Tesseract OCR from https://github.com/tesseract-ocr/tesseract
   - Set the path to the tessdata folder in application.properties:
     ```properties
     tesseract.path=C:/Program Files/Tesseract-OCR/tessdata
     ```
   Note: Make sure to point to the tessdata directory, not the executable.

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
   The application will start on http://localhost:5250

Usage:
------
1. Web Interface:
   - Open your browser and navigate to http://localhost:5250
   - Drag and drop an image onto the upload area or click "Browse" to select a file
   - View the image preview
   - See the extracted text with proper formatting
   - Use the copy button to copy the entire text to clipboard

2. REST API:
   - Endpoint: POST /api/ocr
   - Content-Type: multipart/form-data
   - Parameter name: "image"
   
   Example using curl:
   ```bash
   curl -X POST -F "image=@path-to-your-image.jpg" http://localhost:5250/api/ocr
   ```

   Response format:
   ```json
   {
     "text": "Extracted and formatted text from the image"
   }
   ```

Project Structure:
-----------------
ImageToTextOCR/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── imgtotextocr/
│   │   │           ├── controller/  # REST endpoints
│   │   │           ├── service/     # OCR processing logic
│   │   │           └── util/        # Helper functions
│   │   └── resources/
│   │       ├── templates/           # Thymeleaf templates
│   │       │   └── index.html      # Main web interface
│   │       └── application.properties
├── pom.xml
└── README.md

Testing:
--------
Run the unit tests to verify that the application works as expected:
   mvn test

Contributing:
-------------
Feel free to fork this repository and submit a pull request if you have any improvements or bug fixes.

License:
--------
MIT License

Acknowledgments:
----------------
- Tesseract OCR for the text recognition engine.
- Spring Boot for simplifying web development.
