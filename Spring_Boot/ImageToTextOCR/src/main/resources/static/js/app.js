const dropArea = document.getElementById('drop-area');
const fileElem = document.getElementById('fileElem');
const preview = document.getElementById('preview');
const resultDiv = document.getElementById('result');
const resultBox = document.getElementById('result-box');

// Prevent default drag behaviors
['dragenter', 'dragover', 'dragleave', 'drop'].forEach(eventName => {
    dropArea.addEventListener(eventName, preventDefaults, false);
    document.body.addEventListener(eventName, preventDefaults, false);
});

function preventDefaults(e) {
    e.preventDefault();
    e.stopPropagation();
}

// Highlight drop area
['dragenter', 'dragover'].forEach(eventName => {
    dropArea.addEventListener(eventName, () => {
        dropArea.classList.add('highlight');
    });
});

['dragleave', 'drop'].forEach(eventName => {
    dropArea.addEventListener(eventName, () => {
        dropArea.classList.remove('highlight');
    });
});

// Handle dropped files
dropArea.addEventListener('drop', handleDrop);

function handleDrop(e) {
    const dt = e.dataTransfer;
    const files = dt.files;
    handleFiles(files);
}

fileElem.addEventListener('change', (e) => handleFiles(e.target.files));

function handleFiles(files) {
    if (files.length === 0) return;
    const file = files[0];
    if (!file.type.startsWith('image/')) {
        alert('Please select an image file.');
        return;
    }
    previewImage(file);
    uploadFile(file);
}

function previewImage(file) {
    const reader = new FileReader();
    reader.onload = function(e) {
        preview.src = e.target.result;
        preview.style.display = 'block';
    };
    reader.readAsDataURL(file);
}

function uploadFile(file) {
    resultBox.style.display = 'block';
    resultDiv.textContent = 'Processing...';
    
    const formData = new FormData();
    formData.append('image', file);
    
    fetch('/api/ocr', {
        method: 'POST',
        body: formData
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.text();
    })
    .then(text => {
        // Parse and clean up JSON response
        try {
            // Remove JSON wrapper and clean text
            let cleanText = text;
            if (text.includes('{"text":"')) {
                const jsonObj = JSON.parse(text);
                cleanText = jsonObj.text;
            }
            
            // Convert escaped newlines and clean up the text
            const formattedText = cleanText
                .replace(/\\n/g, '\n')           // Replace \n with actual newlines
                .replace(/\\"/g, '"')            // Replace escaped quotes
                .replace(/^"(.*)"$/, '$1')       // Remove surrounding quotes
                .replace(/^{.*"#/g, '#')         // Remove JSON prefix
                .replace(/\\+/g, '')             // Remove extra backslashes
                .trim();                         // Clean up whitespace
            
            resultDiv.textContent = formattedText || 'No text was extracted from the image.';
        } catch (e) {
            console.error('Error formatting text:', e);
            resultDiv.textContent = text; // Fallback to original text
        }
    })
    .catch((error) => {
        resultDiv.textContent = 'Error processing image. Please try again.';
        console.error('Error:', error);
    });
}

function copyText() {
    const text = resultDiv.textContent;
    navigator.clipboard.writeText(text).then(() => {
        const copyBtn = document.querySelector('.copy-btn');
        const originalText = copyBtn.innerHTML;
        copyBtn.innerHTML = '<i class="fa-solid fa-check"></i>Copied!';
        setTimeout(() => {
            copyBtn.innerHTML = originalText;
        }, 2000);
    }).catch(err => {
        console.error('Failed to copy text:', err);
    });
}
