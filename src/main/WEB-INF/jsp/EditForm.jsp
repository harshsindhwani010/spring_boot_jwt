<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Form</title>
</head>
<body>
    <h1>Edit Form</h1>

   <form method="post" action="/upload" enctype="multipart/form-data">-->
        <!--  <input type="file" name="file" required>-->
          <!--  <input type="file" name="file" accept="pdf" required>--> <!-- Add this line for PDF file upload -->
          <input type="file"
       accept="image/jpeg, image/png, image/gif, image/bmp, application/pdf"
       name="file" id="file" />
        <button type="submit">Upload</button>
    </form>
    <br>

</body>
</html>

    
   
