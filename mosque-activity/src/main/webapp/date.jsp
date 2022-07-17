<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.88.1">
  <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">
  <title>Sign In | Al-Ikwaniah Mosque Acticty System</title>

  <!-- Bootstrap core CSS -->
  <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="bootstrap css/navbar/navbar.css" rel="stylesheet">

  <style>
    .container {
      max-width: 35%;
    }

    .bd-placeholder-img {
      font-size: 1.125rem;
      text-anchor: middle;
      -webkit-user-select: none;
      -moz-user-select: none;
      user-select: none;
    }

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }

    .link a {
      color: black;
      padding-left: 10px;
    }

    .link a:hover {
      color: #92CF4C;
    }
  </style>

  <!-- Custom styles for this template -->
  <link href="css/signup.css" rel="stylesheet">
  
</head>

<body class="text-center">
  <div class="container">
    <div class="bg-light p-5 rounded">
      <div class="col-sm-8 mx-auto">
        <main class="form-signin">
          <form action="DateController" method="post">
            <img class="mb-4" src="assets/brand/mosque.svg" alt="" width="90" height="auto">
            <h1 class="h3 mb-3 fw-normal">Please Enter Details</h1>

            <div class="form-floating">
              <input type="date" class="form-control" id="floatingDate" name="floatingDate">
              <label for="floatingDate">Enter Date</label>
            </div>
            <div class="form-floating">
              <input type="time" class="form-control" id="floatingTime" name="floatingTime">
              <label for="floatingTime">Enter Time</label>
            </div>

            <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>

      

      <p class="mt-5 mb-3 text-muted">&copy; 2017-2021</p>
      </form>
      </main>
    </div>
  </div>
  </div>

</body>

</html>