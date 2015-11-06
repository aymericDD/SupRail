<%-- 
    Document   : addCustomerOrder
    Created on : 5 nov. 2015, 14:54:03
    Author     : Rico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SupRails - Add a customer order</title>
    </head>
    <body>
        <form method="POST">
            <div>
                <label for="firstName">First Name</label>
                <input type="text" id="firstName" name="firstName" />
            </div>
            <div>
                <label for="lastName">Last Name</label>
                <input type="text" id="lastName" name="lastName" />
            </div>
            <div>
                <label for="email">E-mail</label>
                <input type="text" id="email" name="email" />
            </div>
            <div>
                <input type="submit" value="Add" />
            </div>
        </form>
    </body>
</html>

