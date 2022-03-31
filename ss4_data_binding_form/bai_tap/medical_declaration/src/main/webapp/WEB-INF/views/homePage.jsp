<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
            crossorigin="anonymous"></script>
</head>
<body>
<div style="text-align: center">
    <h3>TỜ KHAI Y TẾ</h3>
    <p><span style="color: red">Khuyến cáo : Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</span></p>
</div>

<div class="container">
    <form:form modelAttribute="" action="">

        <div class="form-group">
            <label for="inputAddress">Họ tên (ghi chữ in HOA) <span style="color: red">(*)</span></label>
            <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
        </div>

        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="inputEmail4">Năm sinh <span style="color: red">(*)</span></label>
                <input type="email" class="form-control" id="inputEmail4">
            </div>
            <div class="form-group col-md-4">
                <label for="inputPassword4">Giới tính <span style="color: red">(*)</span></label>
                <input type="password" class="form-control" id="inputPassword4">
            </div>
            <div class="form-group col-md-4">
                <label for="inputPassword4">Quốc tịch <span style="color: red">(*)</span></label>
                <input type="password" class="form-control" id="quocTich">
            </div>
        </div>

        <div class="form-group">
            <label for="inputAddress2">Số hộ chiếu hoặc số CMND <span style="color: red">(*)</span></label>
            <input type="text" class="form-control" id="inputAddress2">
        </div>

        <div class="form-group">
            <label for="inputPassword4">Thông tin đi lại <span style="color: red">(*)</span></label><br>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
                <label class="form-check-label" for="exampleRadios1">
                    Tàu bay
                </label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
                <label class="form-check-label" for="exampleRadios2">
                    Tàu thuyền
                </label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios3" value="option3" disabled>
                <label class="form-check-label" for="exampleRadios3">
                    Ô tô
                </label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios4" value="option3" disabled>
                <label class="form-check-label" for="exampleRadios3">
                    Khác(Ghi rõ)
                </label>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputEmail4">Số hiệu phương tiện</label>
                <input type="email" class="form-control" id="inputEm">
            </div>
            <div class="form-group col-md-6">
                <label for="inputEmail4">Số ghế</label>
                <input type="password" class="form-control" id="inputPasswr">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputPassword4">Ngày khởi hành <span style="color: red">(*)</span></label><br>
                <input type="date" class="form-control" id="inputPaswor">
            </div>
            <div class="form-group col-md-6">
                <label for="inputPassword4">Ngày kết thúc <span style="color: red">(*)</span></label><br>
                <input type="date" class="form-control" id="inputPasswor">
            </div>
        </div>

        <div class="form-group">
            <label for="inputAddress">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào ? <span style="color: red">(*)</span></label>
            <input type="text" class="form-control" id="inputdress">
        </div>

        <div>
            <label for="inputAddress">Địa chỉ liên lạc</label><br>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="inputEmail4">Tỉnh / thành <span style="color: red">(*)</span></label>
                    <input type="email" class="form-control" id="inputail4">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputPassword4">Quận / huyện <span style="color: red">(*)</span></label>
                    <input type="password" class="form-control" id="inputPaord4">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputPassword4">Phường / xẫ <span style="color: red">(*)</span></label>
                    <input type="password" class="form-control" id="quocich">
                </div>
            </div>
        </div>

        <div class="form-group">
            <label for="inputAddress">Địa chỉ nơi ở <span style="color: red">(*)</span></label>
            <input type="text" class="form-control" id="inpuress">
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputEmail4">Điện thoại <span style="color: red">(*)</span></label>
                <input type="email" class="form-control" id="iutEm">
            </div>
            <div class="form-group col-md-6">
                <label for="inputEmail4">Email</label>
                <input type="password" class="form-control" id="inputasswr">
            </div>
        </div>


        <button type="submit" class="btn btn-primary">Sign in</button>
    </form:>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
        integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
        crossorigin="anonymous"></script>
</html>
