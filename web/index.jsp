<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fws</title>

    <!-- Подключение jQuery -->
    <script src="lib/js/jquery-3.3.1.js"></script>

    <!-- Отправка данных формы контроллеру и построение таблицы с результатом решения -->
    <script>
        $(document).ready(function () {
            $("#submit_btn").bind("click", function () {
                $.ajax({
                    url: "/formcontroller",
                    type: "post",
                    data: ({
                        method: $("select[name='method']").val(),
                        kernel: $("select[name='kernel']").val(),
                        x: $("select[name='x']").val(),
                        y: $("select[name='y']").val(),
                        delta: $("select[name='delta']").val()
                    }),
                    success: function (data) {

                        // парсим json и записываем данные в таблицу
                        data = JSON.parse(data);

                        // выдергиваем данные из json
                        var methodSolution = data.methodSolution;
                        var exactSolution = data.exactSolution;
                        var rightParts = data.rightParts;
                        var points = data.points;

                        var numberOfIterations = data.numberOfIterations;
                        var norm1 = data.norm1;
                        var norm2 = data.norm2;
                        var norm3 = data.norm3;

                        $("#table").show();
                        $("#table tbody").empty(); // удаляем все из блока, на случай, если не первый запрос
                        $("#table thead tr:first th:last").text($("select[name='method'] option:selected").text()); // в первую строку последней колонки вставляем название выбранного метода

                        for(var val in methodSolution){
                            // заполняем таблицу
                            $("#table tbody").append(
                                "<tr> <td class='points'>" + points[val] + "</td> <td class='exactSolution'>" + exactSolution[val] + "</td> <td class='rightParts'>" + rightParts[val] + "</td> <td class='methodSolution'>" + methodSolution[val] + "</td> </tr>"
                            );
                        }

                        $("#table tbody").append(
                            "<tr> <td colspan='3'>norma1</td> <td>" + norm1 + "</td> </tr>" +
                            "<tr> <td colspan='3'>norma2</td> <td>" + norm2 + "</td> </tr>" +
                            "<tr> <td colspan='3'>norma3</td> <td>" + norm3 + "</td> </tr>" +
                            "<tr> <td colspan='3'>Количество итераций</td> <td>" + numberOfIterations + "</td> </tr>"
                        );

                    }
                });


            });
        });
    </script>

    <!-- Вычисление эпсилон по дельта -->
    <script>
        $(document).ready(function () {
            $("#eps").text("Точность: " + 1.5 * parseFloat($("select[name='delta'] option:selected").val()) );

            $("#delta").click(function () {
                $("#eps").text("Точность: " + 1.5 * parseFloat($("select[name='delta'] option:selected").val()) );
            });
        });
    </script>

    <!-- Создает массив точек для построения графика -->
    <script>
        $(document).ready(function () {

            $("#graf").click(function () {



            });
        });
    </script>
</head>
<body>

<form action="" method="">

    <select name="method" id="method">
        <option value="1">Метод Ландвебера (МПИ)</option>
        <option value="2">Явный метод 1</option>
        <option value="3">Явный метод 2</option>
        <option value="4">Двухшаговый явный метод</option>
        <option value="5">Явный метод с попеременно чередующимся шагом</option>
        <option value="6">Неявный метод 1</option>
        <option value="7">Неявный метод 2</option>
    </select>

    <select name="kernel" id="kernel">
        <option value="1">Ядро1</option>
        <option value="2">Ядро2</option>
        <option value="3">Ядро3</option>
        <option value="4">Ядро4</option>
        <option value="5">Ядро5</option>
        <option value="6">Ядро6</option>
        <option value="7">Ядро7</option>
        <option value="8">Ядро8</option>
        <option value="9">Ядро9</option>
        <option value="10">Ядро10</option>
        <option value="11">Ядро11</option>
    </select>

    <select name="x" id="x">
        <option value="1">x1</option>
        <option value="2">x2</option>
        <option value="3">x3</option>
        <option value="4">x4</option>
        <option value="5">x5</option>
        <option value="6">x6</option>
        <option value="7">x7</option>
    </select>

    <select name="y" id="y">
        <option value="1">y1</option>
        <option value="2">y2</option>
        <option value="3">y3</option>
        <option value="4">y4</option>
        <option value="5">y5</option>
        <option value="6">y6</option>
        <option value="7">y7</option>
        <option value="8">y8</option>
        <option value="9">y9</option>
    </select>

    <select name="delta" id="delta">
        <option value="0.001">0,001</option>
        <option value="0.0001">0,0001</option>
    </select>

    <label id="eps" for="delta"></label>

    <input id="submit_btn" type="button" name="submit" value="Решить" style="cursor:pointer">

</form>
<div id="table" style="display: none">
    <table>

        <thead>
        <tr>
            <th>Узлы t<sub>i</sub></th>
            <th>Точное решение x<sub>i</sub></th>
            <th>Приближенные правые части y<sub>i</sub></th>
            <th></th>
        </tr>
        </thead>

        <tbody>

        </tbody>

    </table>
</div>

<p id="graf" style="width:600px;height:300px;">График</p>

<div id="test">
    q
</div>