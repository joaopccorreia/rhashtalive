(function () {
	const $video = document.querySelector("video");
	// const $canvas = document.querySelector('canvas');
	const $img = document.querySelector('img');
	
	// const context = $canvas.getContext('2d');
	
	const url = 'ws://localhost:8080/';

	const socket = new WebSocket(url);

	const constraints = {
		video: true,
		audio: true,
	};

	// check device type and return the properties

	navigator.mediaDevices
		.getUserMedia(constraints)
		.then((stream) => ($video.srcObject = stream))
		.catch((error) => console.log(error));

	const getConnectedDevices = (type, callBack) => {
		navigator.mediaDevices.enumerateDevices().then((devices) => {
			const filtered = devices.filter((device) => device.kind === type);
			callBack(filtered);
		});
	};
 
	// const drawCanvas = () => {
	//     context.drawImage($video, 0, 0, $canvas.width, $canvas.height);
	// }
	//
	// setInterval(drawCanvas, 100);
	//
	// let charArray = [];
	//
	// const readCanvas = () => {
	//     const canvasData = $canvas.toDataURL('image/jpeg', 1);
	//     const decodeCanvas = atob(canvasData.split(',')[1]);
	//
	//     for (let i = 0; i < decodeCanvas.length; i++) {
	//         charArray.push(decodeCanvas.charCodeAt(i));
	//     }
    // }
    //
    // const main = () => {
    //     drawCanvas();
    //     readCanvas();
    // }
	//
    // main();
	//
	// socket.send(new Blob([new Uint8Array(charArray)], {
	//     type: 'image/jpeg'
	// }));
	//
	// socket.addEventListener('message', event => {
	//     $img.src = window.URL.createObjectURL(event.data);
	// });

	async function captureMedia(displayMediaOption) {
		let captureScreen = null;
		captureScreen = await navigator.mediaDevices.getUserMedia(displayMediaOption);

		captureScreen.getTracks().forEach(track => $serverVideo.addTrack())
		return captureScreen;
	}

	const $serverVideo = document.querySelector('.server-video');
	$serverVideo.srcObject = captureMedia();

})();
