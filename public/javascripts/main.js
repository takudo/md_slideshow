(function() {
    'use strict';

    var themes,
        selectedThemeIndex,
        instructionsTimeout,
        deck;

    function init() {
        deck = bespoke.from('article', {
            keys: true,
            scale: true,
            bullets: 'li, .bullet',
            progress: true,
            hash: true,
            state: true

        });
//        initThemeSwitching();
    }

    init();


}());