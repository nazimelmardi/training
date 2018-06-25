$(document).ready(function(){
    //Handles menu drop down
    $('.dropdown-menu').find('form').click(function (e) {
        e.stopPropagation();
    });
});


var pattern1 = /^[A-Z][a-z]{1,}\s?[-]?[A-Za-z]{1,}?$/;
var pattern2 = /^[A-Z0-9][A-Z0-9._%+-]{0,63}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/;

$.validator.addMethod("minAge", function(value, element, min) {
                                   var today = new Date();
                                   var birthDate = new Date(value);
                                   var age = today.getFullYear() - birthDate.getFullYear();

                                   if (age > min+1) {
                                       return true;
                                   }
                                   var m = today.getMonth() - birthDate.getMonth();

                                   if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
                                       age--;
                                   }

                                   return age >= min;
                                   }, "You are not old enough!");

$.validator.addMethod(
  "regex",
   function(value, element, regexp) {
       if (regexp.constructor != RegExp)
          regexp = new RegExp(regexp);
       else if (regexp.global)
          regexp.lastIndex = 0;
          return this.optional(element) || regexp.test(value);
   },"Wrong format type"
);

$('form[id="my_form"]').validate({
        rules: {
          fName: {
              required: true,
              regex: pattern1
          },
          lName: {
              required: true,
              regex: pattern1
          },
          email: {
              required: true,
              regex: pattern2
          },
          birthday: {
              required: true,
              minAge: 16
          }
        },
        messages: {
          firstName:{
              required: 'This field is required',
              regex: 'This is an incorrect format'},
          lastName: {
              required: 'This field is required',
              regex: 'This is an incorrect format'},
          email: {
              required: 'This field is required',
              regex: 'This is an incorrect format'},
          birthday: {
              required: "Please enter you date of birth.",
              minAge: "You must be at least 16 years old!"
          }
        },
        submitHandler: function(form) {
          form.submit();
        }
});


