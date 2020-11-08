<html lang=en>
    <head>
        <title>${title}</title>
    </head>
    <body>
        <noscript>
            <strong>We're sorry but lk doesn't work properly without JavaScript enabled. Please enable it to continue.</strong>
        </noscript>
        <div id = "container">
            <form action="http://localhost:8080/authenticate" method="POST">
                <div>
                    <label for="username">Имя пользователя</label>
                    <input type="text" name = "username" value = "" id = "username"/><br>
                </div>
                <div>
                    <label for="password">Пароль</label>
                    <input type="password" name = "password" value = "" id="password"/><br>
                </div>
                <div>
                    <input type="submit" value="Вход">
                </div>    
            </form>
        </div>    
    </body>
</html>