This code support 3 nodes which are :Driver node, Computer node,Server node ,where each Node is determined by a Class,
our code has 3 Classes :
1-class client("Driver")
2-class server("computer")
3-class server2("server node")
There are sockets between 3 nodes where:
class client(has a client socket)
class server(has server socket for client and client socket for server1)
class server1( has server socket)
on our code:
we print all messages from class server and class server1 on class client to show that we operate the 3 nodes with each other

on thread code:
we have made 2 nodes which are class client and class server and use threads by implementing interface runnable to client class and add socket to be connected with server class.

code explanation:
after running server2, server , client 
class server("computer") asks client to enter the location.
class client("Driver") enters the current location 
class server sends the location to class server2("server")
class server2 sends to class server confirmation message that the location 1 is read by it.
class server asks class client to enter where you want to go?.
class client enters the destination location.
class server sends the location to class server2.
class server2 sends to class server confirmation message that location 2 is read by it.
class server asks server 2 to make calculations to get the best recommendation for driver
class server 2 sends the recommendation to class server
class server sends the recommendation to class client and asks if the user needs other location 
if user needs he/she must enter any character except n to repeat loop
if user enters n the program ends