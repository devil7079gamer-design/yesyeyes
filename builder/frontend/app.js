// GitHub Access Details
const GITHUB_TOKEN = "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"; // Yahan Step 1 wala Token paste karein
const REPO_OWNER = "devil7079gamer-design";
const REPO_NAME = "yesyeyes";

async function createBuild() {
    const appName = document.getElementById("appName").value;
    const websiteUrl = document.getElementById("websiteUrl").value;
    const packageName = document.getElementById("packageName").value;
    const result = document.getElementById("result");

    if (!websiteUrl) {
        result.innerHTML = "<p style='color: red;'>⚠️ Please enter a Website URL!</p>";
        return;
    }

    result.innerHTML = "<p style='color: blue;'>⏳ Sending request to GitHub Actions...</p>";

    try {
        const response = await fetch(
            `https://api.github.com/repos/${REPO_OWNER}/${REPO_NAME}/actions/workflows/android.yml/dispatches`,
            {
                method: "POST",
                headers: {
                    "Authorization": `Bearer ${GITHUB_TOKEN}`,
                    "Accept": "application/vnd.github+json",
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    ref: "main",
                    inputs: {
                        app_url: websiteUrl
                    }
                })
            }
        );

        if (response.ok || response.status === 204) {
            result.innerHTML = `
                <p style="color: green; font-weight: bold;">✅ Build Triggered Successfully!</p>
                <p>Aapki app ban rahi hai. GitHub par <b>Actions</b> tab open karke build progress dekhein.</p>
            `;
        } else {
            const errorData = await response.json();
            result.innerHTML = `<p style="color: red;">❌ Error: ${errorData.message || 'Token issue'}</p>`;
        }

    } catch (error) {
        result.innerHTML = "<p style='color: red;'>❌ Connection Error!</p>";
        console.log(error);
    }
}
}
