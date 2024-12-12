Socket Chat Java - Stream Socket (TCP)

Tiếng việt : 

*  Miêu tả ứng dụng:

Cơ bản : 
1.Client đọc dòng văn bản nhập từ bàn phím người dùng ở console , gửi tới server qua Socket
2.Server đọc các dòng văn bản gửi từ Socket
3.Server sẽ chuyển lại dòng văn bản tới một hoặc nhiều các client khác ( ko phải client đã gửi văn bản ) qua Socket
4.Client đọc dòng văn bản từ socket và in ra dòng văn bản nhận được từ server

Nâng cao :
Áp dụng các kiến thức về java core để giải quyết những tình huống phức tạp trong chương trình như  
Khi 2 user cùng gửi tin nhắn cho nhau thì việc khởi tạo ID trong file sẽ có xung đột khi lưu vào file -> trùng lặp ID 
Khi user đang load tin nhắn theo dòng lịch sử thì có tin nhắn mới tới chen vào các tin nhắn lịch sử đang được load -> trùng lặp tin nhắn

English : 

* Application description:

Basic : 
The client reads the text stream from the user's keyboard at the console, sending it to the server via Socket
The server reads lines of text sent from the Socket
The server passes the text back to one or more other clients (not the client that sent the text) via Socket.
The client reads the stream text from the socket and prints the stream text received from the server

Advanced :
Apply java core knowledge to solve complex problems in programming such as  
When two users send messages to each other, creating IDs in the file will conflict when saving to the file -> duplicate IDs 
When the user is downloading messages according to the history stream, a new message arrives and interferes with the historical messages being downloaded -> duplicate messages.
