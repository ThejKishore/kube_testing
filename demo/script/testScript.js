const newman = require('newman'); // require newman in your project

// call newman.run to pass `options` object and wait for callback
newman.run({
    collection: require('./../postman/Book.postman_collection.json'),
    reporters: 'htmlextra'
}, function (err) {
    if (err) { throw err; }
    console.log('collection run complete!');
});