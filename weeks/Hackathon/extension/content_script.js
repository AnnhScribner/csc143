// let images = document.querySelectorAll('img');
// images.forEach((img) => {
//     console.log(img.src);

//     fetch("http://127.0.0.1:5000/anna", {
//         method: "POST",
//         headers: {
//             "Content-Type": "application/json"
//         },
//         body: JSON.stringify({ image_url: img.src })
//     })
//     .then(response => response.json())
//     .then(data => {
//         console.log("Server response:", data);
//     })
//     .catch(error => {
//         console.error("Error contacting server:", error);
//     });
    
// });


async function processImages() {
    let images = document.querySelectorAll('img');

    for (const img of images) {
        
        try {
            const response = await fetch("http://127.0.0.1:5000/anna", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({ image_url: img.src })
            });

            const data = await response.json();
            console.log("Server response:", data);
            console.log(img.src);

            // Here you can already put the watermark or process the image
        } catch (error) {
            console.error("Error contacting server:", error);
        }
    }
}

processImages();  // Call the async function
