import socket
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind(('localhost', 12345))
server.listen(5)
print("Server is waiting for connection...")
results = {
    "101": "Pass - 85 Marks",
    "102": "Pass - 92 Marks",
    "103": "Fail - 35 Marks"
}
while True:
    conn, addr = server.accept()
    print("Connected to:", addr)
    reg_no = conn.recv(1024).decode()
    result = results.get(reg_no, "Register Number Not Found")
    conn.send(result.encode())
    conn.close()
import socket

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

client.connect(('localhost', 12345))

reg_no = input("Enter Register Number: ")

client.send(reg_no.encode())

result = client.recv(1024).decode()

print("Student Result:", result)

client.close()
