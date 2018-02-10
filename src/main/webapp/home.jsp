<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Inicial</title>
    </head>
    <body>
        <h1>${usuario.nome}</h1>
        <h1>${usuario.senha}</h1>
         <img src="<c:url value="${usuario.caminhoImagem}" />"  />
     
    </body>
</html>
