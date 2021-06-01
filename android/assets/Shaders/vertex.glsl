attribute vec4 a_position;
attribute vec4 a_color;
attribute vec2 a_texCoord0;

// Data sent from libgdx SpriteBatch
//(Read Only and the same for all vertex|pixel)
uniform mat4 u_projTrans;
uniform float time;
uniform vec2 resolution;
uniform mouse;

// Variable Data for storing data to pass to fragment Shader
varying vec4 v_color;
varying vec2 v_texCoords;

void main()
{
    vec4 v = gl_FragCoord/resolution.x;

    v_color = vec4(v);

    v_texCoords = a_texCoord0;

    gl_Position =  u_projTrans * a_position;
}
