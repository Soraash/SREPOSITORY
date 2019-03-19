$(document).ready(function () {
    $("button").addClass('btn btn-primary');

    $("button#b1").click(function () {
        $('#1').addClass('bg-light text-dark');
        $('#para1').addClass('bg-light text-dark');
        $('#para2').addClass('bg-light text-dark')
    });


    $("button#b2").click(function () {
        $('#1').addClass('bg-dark text-white');
        $('#para1').addClass('bg-dark text-white');
        $('#para2').addClass('bg-dark text-white');
    });


    $("button#b3").click(function () {
        $('#para1').addClass('bg-secondary text-dark');
        $('#para2').addClass('bg-secondary text-dark');
    });

    $("button#b4").click(function () {
        $('#para1').addClass('bg-warning text-dark');
        $('#para2').addClass('bg-warning text-dark');
    });

})