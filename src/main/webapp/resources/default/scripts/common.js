$(function() {
	$.fn.deleteData = function(url, data) {
		var thatArea = $(this);
		thatArea.on('click', '[data-btn-type=delete]', function() {
			if (!confirm('确定要删除吗？'))
				return false;
			var thatBtn = $(this);
			var id = thatBtn.attr('data-id');
			if (data == undefined) {
				data = {
					id : id
				};
			}
			$.post(url, data, function(data) {
				alert(data.message);
				if (data.code == 200) {
					// 移除该行
					thatBtn.parents('tr').fadeOut();
					var thatTotal = thatArea.find('.total-font');
					var total = thatTotal.html();
					thatTotal.html(parseInt(total - 1));
				}
			});

		});
	}; // delete end
});

function doSubmit(form) {
	$(form).ajaxSubmit({
		success : function(data) {
			alert(data.message);
			if (data.code == 200) {
				document.forms[0].reset();
				if(data.url!="" && data.url!=null && data.url!=undefined && data.url!="undefined"){
					window.location.href=data.url;
				}
			}
		}
	});
	return false;
}

