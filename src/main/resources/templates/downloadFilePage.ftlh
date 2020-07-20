<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>DownloadFilePage</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
              integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
              crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/6c024fbb60.js" crossorigin="anonymous"></script>
    </head>
    <body onload="">
    <div id="parent">
        <div id="child">
            <form method="get" action="/download/${link}">
                <h3>${fileName}<br></h3>
                <input style="color: darkcyan" type="submit" value="Сохранить">
            </form>
        </div>
    </div>
    </body>
</html>