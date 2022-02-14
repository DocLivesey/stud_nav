<#macro page>
    <!DOCTYPE html>
    <head>
        <meta charset="UTF-8">
        <title>Навигатор</title>
    </head>
    <body>
    <#nested>
    </body>
    </html>
</#macro>

<#macro login_form path>
    <form action="${path}" method="post">
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div><input type="submit" value="Sign In"/></div>
    </form>
</#macro>