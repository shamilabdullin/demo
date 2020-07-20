<#macro html>
    <!DOCTYPE html>
    <html lang="en">
    <#nested>
    </html>
</#macro>

<#macro head title>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>${title}</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
              integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
              crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/6c024fbb60.js" crossorigin="anonymous"></script>
        <#nested>

    </head>
</#macro>

<#macro body onload="">
    <body onload="${onload}">
    <#nested>
    </body>
</#macro>