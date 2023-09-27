
    function newAuth() {
    window.FHIR = {
        client: this.client,
        oauth2: this.oauth2
    };
    function relative() {
    return ("https://31e2-150-107-190-51.ngrok-free.app");
}

    // var Client;
    FHIR.oauth2.authorize({
    'client_id': '3225e906-309f-4fb2-b4ce-05b4b049a2b2', //Your app client ID
    'scope': 'PATIENT.READ, PATIENT.SEARCH, OBSERVATION.READ',//'patient/*.read launch'
    'state': 'code',
    'redirect_uri': relative(),
}
    );
    // function auth(fhirServiceUrl, callback) {
    //     callback && callback({
    //         "url": fhirServiceUrl || urlParam("fhirServiceUrl")
    //     });
    //
    // }
    // FHIR.oauth2.ready()
    //     .then(function(client){
    //         myapp.smart = client
    //         console.log(client);
    //     })
    var req = "/patientList"
    // "address=123%20Main%20St.&" +
    // "address-city=Madison&" +
    // "address-postalcode=53703&" +
    // "address-state=Wisconsin&" +
    // "family=Mychart&" +
    // "gender=Female&" +
    // "given=Allison&" +
    // "telecom=608-12  3-4567"

    FHIR.oauth2.ready( client => client.request(req) ).then(function(output){
    console.log("output",output);
});
    var client = params.client;
    // var client_id = null;
    // var response_type = 'code';
    // var scope = "/launch";
    // var redirect_uri = relative("");
    var state = 'state';
    // var redirect_to =
    //     "client_id=" + encodeURIComponent(client.client_id) + "&" +
    //     "response_type=" + encodeURIComponent(client.response_type) + "&" +
    //     "scope=" + encodeURIComponent(client.scope) + "&" +
    //     "redirect_uri=" + encodeURIComponent(client.redirect_uri) + "&" +
    //     "state=" + encodeURIComponent(state);
    //  location.href = redirect_to;

    function hy(params, errback) {
    if (!errback) {
    errback = function () {
    console.log("Failed to discover authorization URL given", params);
};
} else {
    relative();
}
}
}

