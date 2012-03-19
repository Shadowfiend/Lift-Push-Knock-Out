(function() {
  var formId = ko.observable(undefined),
      submitId = ko.observable(undefined),
      chatFieldId = ko.observable(undefined);

  $(document).ready(function() {
    $('#chat').submit(function() {
      return false;
    })
  })
})();
