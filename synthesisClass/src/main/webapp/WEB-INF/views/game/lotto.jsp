<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로또 번호 생성기</title>
<style>
	body {
	    background-image: url('/images/lotto.jpg');
	    background-size: cover; /* 배경 이미지를 화면에 맞게 크기 조정 */
	    background-position: center; /* 배경 이미지 위치 중앙 정렬 */
	    background-attachment: fixed; /* 스크롤 시 배경 이미지 고정 */
	    background-repeat: no-repeat; /* 이미지 반복 안함 */
	    margin: 0; /* 기본 마진 제거 */
	    padding: 0; /* 기본 패딩 제거 */
	    display: flex;
	    justify-content: center;
	    align-items: center;
	    min-height: 100vh; /* 화면 크기에 맞게 높이 설정 */
	    text-align: center;
	    flex-direction: column;
	}
	
	.container {
	    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
	    padding: 40px;
	    max-width: 600px;
	    width: 100%;
	    margin: 0 auto;
	    background: rgba(255, 255, 255, 0.8); /* 배경에 투명도 추가 */
	    border-radius: 12px;
	    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
	}
	
	.title {
	    font-size: 40px;
	    font-weight: 900;
	    letter-spacing: 3px;
	    padding: 20px 30px;
	    border-radius: 12px;
	    background: linear-gradient(135deg, #ffcc00, #ff6666, #66ccff, #99ff99);
	    background-size: 400% 400%;
	    color: #fff;
	    animation: gradientMove 5s ease infinite;
	    text-shadow: 2px 2px 4px rgba(0,0,0,0.2);
	    box-shadow: 0 8px 16px rgba(0,0,0,0.1);
	    margin-bottom: 30px;
	}
	
	@keyframes gradientMove {
	    0% { background-position: 0% 50%; }
	    50% { background-position: 100% 50%; }
	    100% { background-position: 0% 50%; }
	}
	
	.state-box {
	    display: inline-block;
	    padding: 12px 24px;
	    background: #ffffff;
	    border-left: 6px solid #007BFF;
	    border-radius: 10px;
	    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
	    margin-bottom: 30px;
	    font-size: 18px;
	}
	
	#stateVal {
	    font-weight: bold;
	    color: #007BFF;
	}
	
	.lotto-container {
	    display: flex;
	    justify-content: center;
	    gap: 15px;
	    margin: 20px 0 40px 0;
	}
	
	.lotto-number {
	    width: 70px;
	    height: 70px;
	    line-height: 70px;
	    border-radius: 50%;
	    background: linear-gradient(135deg, #ffeb3b, #ff9800, #4caf50, #2196f3, #9c27b0, #f44336);
	    background-size: 300% 300%;
	    animation: lottoGradientMove 4s ease infinite;
	    font-size: 24px;
	    font-weight: bold;
	    color: #fff;
	    box-shadow: 0 4px 10px rgba(0,0,0,0.2);
	    display: inline-block;
	    transition: 0.3s;
	}
	
	@keyframes lottoGradientMove {
	    0% { background-position: 0% 50%; }
	    50% { background-position: 100% 50%; }
	    100% { background-position: 0% 50%; }
	}
	
	#num1 {
	    background: linear-gradient(135deg, #ffeb3b, #fff176); /* 노랑 */
	    color: #000;
	}
	
	#num2 {
	    background: linear-gradient(135deg, #2196f3, #64b5f6); /* 파랑 */
	    color: #fff;
	}
	
	#num3 {
	    background: linear-gradient(135deg, #f44336, #e57373); /* 빨강 */
	    color: #fff;
	}
	
	#num4 {
	    background: linear-gradient(135deg, #4caf50, #81c784); /* 초록 */
	    color: #fff;
	}
	
	#num5 {
	    background: linear-gradient(135deg, #ff9800, #ffb74d); /* 주황 */
	    color: #000;
	}
	
	#num6 {
	    background: linear-gradient(135deg, #9c27b0, #ba68c8); /* 보라 */
	    color: #fff;
	}
	
	button {
	    padding: 12px 24px;
	    margin: 10px;
	    border: none;
	    border-radius: 8px;
	    font-size: 16px;
	    font-weight: bold;
	    color: white;
	    cursor: pointer;
	    transition: background 0.3s;
	    box-shadow: 0 3px 6px rgba(0, 0, 0, 0.1);
	}
	
	#start {
	    background-color: #28a745;
	}
	
	#start:hover {
	    background-color: #218838;
	}
	
	#end {
	    background-color: #dc3545;
	}
	
	#end:hover {
	    background-color: #c82333;
	}

</style>

</head>
<body>
	<%@ include file="/WEB-INF/views/common/navbar.jsp" %>
	<div class="container">
    <div class="title">🎉 로또번호 생성기 🎉</div>
    <div class="state-box">
        상태 : <span id="stateVal"></span>
    </div>

    <div class="lotto-container">
        <div id="num1" class="lotto-number">0</div>
        <div id="num2" class="lotto-number">0</div>
        <div id="num3" class="lotto-number">0</div>
        <div id="num4" class="lotto-number">0</div>
        <div id="num5" class="lotto-number">0</div>
        <div id="num6" class="lotto-number">0</div>
    </div>

    <div>
        <button id="start" type="button">start</button>
        <button id="end" type="button">end</button>
    </div>
    </div>

    <!-- 👇 원본 JavaScript 그대로 유지 -->
    <script>
        // 6개의 로도번호 생성
        let arr = new Array(45);
        for(let i=0; i<arr.length; i++) {
            arr[i] = i+1;
        }
        for(let i=0; i<10000; i++) {
            let temp = arr[0];
            let rnum = Math.floor(Math.random()*45);
            arr[0] = arr[rnum];
            arr[rnum] = temp;
        } // 0~5까지만 로도번호로 사용

        let state = '멈춤';
        document.querySelector('#stateVal').innerHTML = state;

        let num1, num2, num3, num4, num5, num6;

        document.querySelector('#start').addEventListener('click', function() {
            if(state == 'start') {
                return;
            }

            state  = '추출중';
            document.querySelector('#stateVal').innerHTML = state;

            num1 = setInterval(function(){
                document.querySelector('#num1').innerHTML = Math.floor(Math.random()*45) + 1;
            } , 50);
            
            num2 = setInterval(function(){
                document.querySelector('#num2').innerHTML = Math.floor(Math.random()*45) + 1;
            } , 50);
            
            num3 = setInterval(function(){
                document.querySelector('#num3').innerHTML = Math.floor(Math.random()*45) + 1;
            } , 50);
            
            num4 = setInterval(function(){
                document.querySelector('#num4').innerHTML = Math.floor(Math.random()*45) + 1;
            } , 50);
            
            num5 = setInterval(function(){
                document.querySelector('#num5').innerHTML = Math.floor(Math.random()*45) + 1;
            } , 50);
            
            num6 = setInterval(function(){
                document.querySelector('#num6').innerHTML = Math.floor(Math.random()*45) + 1;
            } , 50);
        });

        document.querySelector('#end').addEventListener('click', function() {
            if(state == 'end') {
                return;
            }

            setTimeout(function() {
                clearInterval(num1);
                document.querySelector('#num1').innerHTML = arr[0];
            }, 1)
            setTimeout(function() {
                clearInterval(num2);
                document.querySelector('#num2').innerHTML = arr[1];
            }, 1000)
            setTimeout(function() {
                clearInterval(num3);
                document.querySelector('#num3').innerHTML = arr[2];
            }, 2000)
            setTimeout(function() {
                clearInterval(num4);
                document.querySelector('#num4').innerHTML = arr[3];
            }, 3000)
            setTimeout(function() {
                clearInterval(num5);
                document.querySelector('#num5').innerHTML = arr[4];
            }, 4000)
            setTimeout(function() {
                clearInterval(num6);
                document.querySelector('#num6').innerHTML = arr[5];
            }, 5000)

            state  = '멈춤';
            document.querySelector('#stateVal').innerHTML = state;
        });
    </script>
</body>
</html>