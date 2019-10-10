$(function() {
    jQuery.fn.extend({
        disable: function(state) {
            return this.each(function() {
                this.disabled = state;
            });
        }
    });

    $('input[type="submit"], input[type="button"], button').disable(true);
});