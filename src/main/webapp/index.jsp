<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
    </head>
    <body>
        <form method="POST" action="usuario/adicionar" enctype="multipart/form-data">
            <input type="text" name="nome" required/><br>
            <input type="text" name="senha" required/><br>
            <input type="file" name="foto" accept="image/*" required><br>
            <input type="submit" value="Cadastrar"/>
        </form>
        <hr>
        <form method="POST" action="usuario/autenticar">
            <input type="text" name="nome" required/><br>
            <input type="text" name="senha" required/><br>
            <input type="submit" value="Autenticar"/>
        </form>
    </body>
</html>
