# Cordova Vibration Plugin

Este es un plugin Cordova custom para vibración en dispositivos Android.

## Tipos de Vibración

Los diferentes tipos de vibración que se pueden usar son:

- `error` : Vibración corta y repetitiva para indicar un error.
- `success` : Vibración doble corta para indicar éxito.
- `warning` : Vibración larga repetitiva para indicar una advertencia.
- `info` : Vibración muy corta para información general.

## Ejemplo de Utilización

```javascript
window.plugins.vibrationPlugin.vibrate('error', function() {
    console.log('Vibration success');
}, function(err) {
    console.error('Vibration error: ' + err);
});
```

## Autor

wcarmona

## Versión

1.0.0