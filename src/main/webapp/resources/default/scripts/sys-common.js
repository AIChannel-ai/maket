$(function() {

	$.fn.loadDataByLeft = function(urlRoot, data) {
		$(this).on('click', '[data-type=left-nav]', function() {
			$('#accordion a').removeClass('active');
			$(this).addClass('active');

			var url = $(this).attr('data-url');
			asynLoadData(urlRoot + '/' + url, '#sz_right', data);
		});
	};

	$.fn.loadDataByEdit = function(urlRoot, data) {

		$(this).on('click', '[data-btn-type=edit]', function() {

			var url = $(this).attr('data-url');

			asynLoadData(urlRoot + '/' + url, '#sz_right', data);
		});
	};

	// no use
	$(document).on('click', '#btn-submit', function() {
		$('#form1').ajaxSubmit({
			success : function(data) {
				alert(data.message);
				if (data.code == 200) {
					document.forms[0].reset();
				}
			}
		});
	});

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

	// ****自定义的load**** //
	$.fn.loadDataByCustom = function(urlRoot, button, data) {

		$(this).on('click', button, function() {

			var url = $(this).attr('data-url');

			asynLoadData(urlRoot + '/' + url, '#sz_right', data);
		});
	};

	// ****执行****//
	$.fn.execute = function(url, button,callback, data) {
		var thatArea = $(this);
		thatArea.on('click', button, function() {
			if (!confirm('确定要执行此操作吗？'))
				return false;
			var thatBtn = $(this);
			var id = thatBtn.attr('data-id');
			data = $.extend({
				id: id
	        }, {});
			$.post(url, data, function(data) {
				alert(data.message);
				if(callback){
					callback();
				}
			});

		});
	};
});

function asynLoadData(url, ContentId, data) {

	var datas = $.extend(data,{});
	$.ajax({
		url : url,
		type : "POST",
		data : datas,
		success : function(data) {
			// checkLogin(data);
			$(ContentId).html(data);
		},
		error : function(xhr, errmsg, errobject) {
			alert(errmsg);
		}
	});
}

function doSubmit(form) {
	$(form).ajaxSubmit({
		success : function(data) {
			alert(data.message);
			if (data.code == 200) {
				document.forms[0].reset();
				if(data.url!="" && data.url!=null && data.url!=undefined && data.url!="undefined"){
					asynLoadData(data.url, '#sz_right', data);
				}
			}
		}
	});
	return false;
}
// *******************************//
$(function() {
	var Accordion = function(el, multiple) {
		this.el = el || {};
		this.multiple = multiple || false;

		// Variables privadas
		var links = this.el.find('.link');
		// Evento
		links.on('click', {
			el : this.el,
			multiple : this.multiple
		}, this.dropdown)
	}

	Accordion.prototype.dropdown = function(e) {
		var $el = e.data.el;
		$this = $(this), $next = $this.next();

		$next.slideToggle();
		$this.parent().toggleClass('open');

		if (!e.data.multiple) {
			$el.find('.submenu').not($next).slideUp().parent().removeClass(
					'open');
		}
		;
	}

	var accordion = new Accordion($('#accordion'), false);
});