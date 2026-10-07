import requests


post_response = requests.post(
    "http://localhost:8080/customers/save",
    json={
        "name": "Kaan",
        "customerStreet": "71 Egham Hill The Pad",
        "customerCity": "Surrey"
    }
)

print(post_response.text)
