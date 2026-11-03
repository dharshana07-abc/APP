import socket

server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

server.bind(('localhost', 12345))

print("UDP Server is waiting for data...")

while True:
    data, addr = server.recvfrom(1024)

    temperature = data.decode()

    print("Temperature Received:", temperature, "°C")
    print("From:", addr)
