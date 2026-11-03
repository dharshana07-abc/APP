import socket
client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
while True:
    temperature = input("Enter Temperature (or exit): ")
    if temperature.lower() == "exit":
        break
    client.sendto(
        temperature.encode(),
        ('localhost', 12345)
    )
client.close()
