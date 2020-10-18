$(document).ready(function(){
    var but;
    $('form').submit(function(){
        but= $(this).find('button[type=submit]');
        but.attr({disabled: true});
        $.ajax({
            type: 'POST',
            url: 'check.php', 
            data: $(this).serialize()
        })
        .done(function(data){
            but.attr({disabled: false});
            try{
                var jsData = JSON.parse(data);
                var alertOptions = {};
                alertOptions.title 					= jsData.title;
                alertOptions.text 					= jsData.text;
                alertOptions.html 					= jsData.html;
                alertOptions.type 					= jsData.type;
                alertOptions.isCancel 				= jsData.isCancel;
                alertOptions.urlRedirection			= jsData.urlRedirection;
                alertOptions.confirmText 			= jsData.confirmText;
                alertOptions.cancelText 			= jsData.cancelText;
                alertOptions.isAlertAfterConfirm	= jsData.isAlertAfterConfirm;
                alertOptions.titleAfterConfirm		= jsData.titleAfterConfirm;
                alertOptions.textAfterConfirm		= jsData.textAfterConfirm;
                alertOptions.typeAfterConfirm		= jsData.typeAfterConfirm;
                alertOptions.urlRedirAfterConfirm	= jsData.urlRedirAfterConfirm;
                alertOptions.isAlertAfterCancel 	= jsData.isAlertAfterCancel;
                alertOptions.titleAfterCancel 		= jsData.titleAfterCancel;
                alertOptions.textAfterCancel 		= jsData.textAfterCancel;
                alertOptions.typeAfterCancel 		= jsData.typeAfterCancel;
                alertOptions.urlRedirAfterCancel	= jsData.urlRedirAfterCancel;
                alertThis(alertOptions);
            } catch(e){
                console.log(data);
                console.log(e);
            }
        });
        return false;
    });


    $('.ajaxClick').click(function(){
        $.ajax({
            type: 'POST',
            url: 'check.php', 
            data: "act="+$(this).data('act')+"&values="+$(this).data('values')
        })
        .done(function(data){
            try{
                var jsData = JSON.parse(data);
                var alertOptions = {};
                alertOptions.title 					= jsData.title;
                alertOptions.text 					= jsData.text;
                alertOptions.html 					= jsData.html;
                alertOptions.type 					= jsData.type;
                alertOptions.isCancel 				= jsData.isCancel;
                alertOptions.urlRedirection			= jsData.urlRedirection;
                alertOptions.confirmText 			= jsData.confirmText;
                alertOptions.cancelText 			= jsData.cancelText;
                alertOptions.isAlertAfterConfirm	= jsData.isAlertAfterConfirm;
                alertOptions.titleAfterConfirm		= jsData.titleAfterConfirm;
                alertOptions.textAfterConfirm		= jsData.textAfterConfirm;
                alertOptions.typeAfterConfirm		= jsData.typeAfterConfirm;
                alertOptions.urlRedirAfterConfirm	= jsData.urlRedirAfterConfirm;
                alertOptions.isAlertAfterCancel 	= jsData.isAlertAfterCancel;
                alertOptions.titleAfterCancel 		= jsData.titleAfterCancel;
                alertOptions.textAfterCancel 		= jsData.textAfterCancel;
                alertOptions.typeAfterCancel 		= jsData.typeAfterCancel;
                alertOptions.urlRedirAfterCancel	= jsData.urlRedirAfterCancel;
                alertThis(alertOptions);
            } catch(e){
            }
        });
        return false;
    });

    function alertThis(options = {}){
        /*
            options.title 					= "success";
            options.text 					= "Je suis Formidable";
            options.type 					= "warning"; //error, warning, success
            options.urlRedirection			= "../index.php"; //Redirect to this URL after confirm Alert
            options.isCancel 				= true; //true if cancelable, false if not
            options.confirmText 			= "je COnfirme";
            options.cancelText 				= "J'annule";
            options.isAlertAfterConfirm		= true; //true if show Alert After Confirmation, false if not
            options.titleAfterConfirm		= "Je suis bien";
            options.textAfterConfirm		= "Je vais Bien";
            options.typeAfterConfirm		= "success"; //error, warning, success
            options.urlRedirAfterConfirm	= "../index.php"; //Redirect to this URL after Alert After confirm Alert
            options.isAlertAfterCancel 		= true; //true if show Alert After Cancel, false if not
            options.titleAfterCancel 		= "Je suis Mauvais";
            options.textAfterCancel 		= "Je ne vais Pas bien du tout";
            options.typeAfterCancel 		= "error";
            options.urlRedirAfterCancel		= "../index.php"; //Redirect to this URL after Alert After cancel Alert
        */
        swal.fire({
            title: (options.title !== undefined) ? options.title : "",
            text: (options.text !== undefined) ? options.text : "",
            html: (options.html !== undefined) ? options.html : "",
            icon: (options.type !== undefined) ? options.type : "success",
            showCancelButton: (options.isCancel !== undefined) ? options.isCancel : false,
            confirmButtonText: (options.confirmText !== undefined) ? options.confirmText : "",
            cancelButtonText: (options.cancelText !== undefined) ? options.cancelText : "",
            focusConfirm: false,
            allowOutsideClick: false,
            reverseButtons: false
        }).then((result) => {
            console.log(result);
            if (result.value) {
                if(options.isAlertAfterConfirm)
                    swal.fire(options.titleAfterConfirm, options.textAfterConfirm, options.typeAfterConfirm)
                        .then(function(){
                            if(options.urlRedirAfterConfirm)	window.location = options.urlRedirAfterConfirm;
                        });
                else {
                    if(options.urlRedirection)	window.location = options.urlRedirection;
                }
            } else if (result.dismiss === Swal.DismissReason.cancel) {
                if(options.isAlertAfterCancel) 
                    swal.fire(options.titleAfterCancel, options.textAfterCancel, options.typeAfterCancel)
                        .then(function(){
                            if(options.urlRedirAfterCancel)	window.location = options.urlRedirAfterCancel;
                        });
            }
        });
    }
});