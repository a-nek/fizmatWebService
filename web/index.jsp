<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <form action="/formcontroller" method="post">

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
        <option value="">Ядро1</option>
        <option value="">Ядро2</option>
        <option value="">Ядро3</option>
        <option value="">Ядро4</option>
        <option value="">Ядро5</option>
        <option value="">Ядро6</option>
        <option value="">Ядро7</option>
        <option value="">Ядро8</option>
        <option value="">Ядро9</option>
        <option value="">Ядро10</option>
        <option value="">Ядро11</option>
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

      <input type="submit" name="submit" value="Решить">

    </form>
  </body>
</html>