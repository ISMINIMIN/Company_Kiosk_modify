var IMP = window.IMP; // 생략가능
IMP.init('imp32651341'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
  	
IMP.request_pay({
    	pg : 'kakao', // version 1.1.0부터 지원.
    	pay_method : 'card',
    	merchant_uid : 'merchant_' + new Date().getTime(),
    	name : '주문명',
    	amount : 20000,
    	m_redirect_url : 'https://www.yourdomain.com/payments/complete'
    	}, function(rsp) {
    		if ( rsp.success ) {
    			var msg = '결제가 완료되었습니다.';
    		} else {
    			var msg = '결제에 실패하였습니다.';
    			msg += '에러내용 : ' + rsp.error_msg;
    		}
    		alert(msg);
    	});